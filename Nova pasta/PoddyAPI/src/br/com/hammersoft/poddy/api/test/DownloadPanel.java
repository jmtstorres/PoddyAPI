package br.com.hammersoft.poddy.api.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import com.rometools.rome.feed.synd.SyndEntry;

import br.com.hammersoft.net.http.HttpURLConnector;
import br.com.hammersoft.net.http.IDownloadProgressListener;
import br.com.hammersoft.ui.ProgressCircleUI;

public class DownloadPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2967783664950976285L;
	private JProgressBar progressBar;
	protected String url;
	private HttpURLConnector conn;
	protected boolean cancelled;
	private SyndEntry entry;

	/**
	 * Create the panel.
	 */
	public DownloadPanel(SyndEntry entry, String outFile) {
		Dimension d = new Dimension(250, 50);

		setLayout(new BorderLayout(0, 0));
		setFont(new Font("Tahoma", Font.BOLD, 13));

		setPreferredSize(d);
		setMinimumSize(d);
		setMaximumSize(d);
		setSize(d);
		
		this.entry = entry;

		url = entry.getEnclosures().get(0).getUrl();

		JLabel lblNewLabel = new JLabel("<html>" + entry.getTitle() + "</html>");
		add(lblNewLabel, BorderLayout.CENTER);

		progressBar = new JProgressBar();
		progressBar.setFont(new Font("Tahoma", Font.BOLD, 13));
		progressBar.setBorderPainted(false);
		progressBar.setStringPainted(true);
		progressBar.setBorder(null);
		progressBar.setPreferredSize(new Dimension(50, 50));
		progressBar.setMinimumSize(new Dimension(50, 50));
		progressBar.setMaximumSize(new Dimension(50, 50));
		progressBar.setUI(new ProgressCircleUI());
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setValue(0);
		progressBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(!cancelled){
					lblNewLabel.setText("Cancelar?");
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				if(!cancelled){
					lblNewLabel.setText("<html>" + entry.getTitle() + "</html>");
				}
			}
			
			public void mouseClicked(MouseEvent e){
				conn.cancelDownload();
				cancelled = true;
				lblNewLabel.setText("Cancelado");
				Thread t = new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						DownloadPanel.this.getParent().remove(DownloadPanel.this);
						DownloadPanel.this.getParent().revalidate();
						DownloadPanel.this.getParent().repaint();
					}
				});
				
				t.start();
			}
		});
		add(progressBar, BorderLayout.EAST);

	}
	
	public void startDownload() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					conn = new HttpURLConnector();
					File dir = new File(entry.getAuthor());
					if(!dir.exists()){
						dir.mkdir();
					}
					conn.downloadFile(url, dir + File.separator +  conn.parseUrlForFileName(url), new IDownloadProgressListener() {

						int progressLast = 0;

						@Override
						public void updated(int progress) {
							if (progress >= progressLast + 1) {
								progressLast = progress;
								progressBar.setValue(progress);
								revalidate();
								repaint();
							}
						}

						@Override
						public void started(long size) {
							progressBar.setValue(0);
							revalidate();
							repaint();
						}

						@Override
						public void failed(int reason) {
							setVisible(false);
							// TODO - mostrar box com falha
						}

						@Override
						public void complete() {
							setVisible(false);
							// TODO - mostrar box com sucesso e marcar episódio
							// como baixado
						}
					});
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		t.start();
	}
}
