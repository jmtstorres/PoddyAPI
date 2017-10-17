package br.com.hammersoft.poddy.api.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;

import br.com.hammersoft.net.http.HttpURLConnector;
import br.com.hammersoft.net.http.IDownloadProgressListener;
import br.com.hammersoft.poddy.api.PoddyAPI;
import br.com.hammersoft.poddy.api.exception.PoddyAPIException;
import br.com.hammersoft.poddy.api.pojo.Result;
import br.com.hammersoft.ui.ProgressCircleUI;

public class PanelPodcastInfo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8064498452308601207L;
	private JLabel lblFilename;
	private JProgressBar progressBar;

	/**
	 * Create the panel.
	 * 
	 * @throws PoddyAPIException
	 */
	public PanelPodcastInfo(Result result, JPanel downloadPanel) throws PoddyAPIException {
		setLayout(new BorderLayout(0, 0));

		SyndFeed feed = PoddyAPI.getPodcastFeed(result);

		JLabel lblNewLabel = new JLabel(result.getArtistName());
		try {
			lblNewLabel.setIcon(new ImageIcon(new URL(result.getArtworkUrl100())));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setSize(new Dimension(getWidth(), 100));
		lblNewLabel.setPreferredSize(new Dimension(getWidth(), 100));
		lblNewLabel.setMinimumSize(new Dimension(getWidth(), 100));
		add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);

		JLabel lblDescription = new JLabel();
		panel_2.add(lblDescription);
		lblDescription.setText("<html>" + feed.getDescription() + "</html>");

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				Dimension d = new Dimension(panel_1.getWidth() - 100, panel_1.getHeight());
				panel_1.setSize(d);
				panel_1.setPreferredSize(d);
				panel_1.setMaximumSize(d);
				panel_1.setMinimumSize(d);

				d = new Dimension(1024, 50);
				for (SyndEntry entry : feed.getEntries()) {
					JLabel label = new JLabel("<html>" + entry.getTitle() + "</html>");
					label.setSize(d);
					label.setPreferredSize(d);
					label.setMaximumSize(d);
					label.setMinimumSize(d);
					panel_1.add(label);

					label.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							super.mouseClicked(e);
							String outFile = entry.getAuthor() + File.pathSeparator + entry.getSource().getTitle();
							DownloadPanel download = new DownloadPanel(entry, outFile);
							downloadPanel.add(download);
							download.startDownload();
						}
					});
				}

				d = new Dimension(panel_1.getWidth(), 50 * feed.getEntries().size());
				panel_1.setSize(d);
				panel_1.setPreferredSize(d);
				panel_1.setMaximumSize(d);
				panel_1.setMinimumSize(d);
				panel_1.revalidate();
				panel_1.repaint();

				scrollPane.revalidate();
				scrollPane.repaint();
			}
		});

		t.start();
	}
}
