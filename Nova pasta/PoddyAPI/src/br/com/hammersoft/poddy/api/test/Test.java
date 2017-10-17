package br.com.hammersoft.poddy.api.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.hammersoft.poddy.api.PoddyAPI;
import br.com.hammersoft.poddy.api.exception.PoddyAPIException;
import br.com.hammersoft.poddy.api.media.MediaType;
import br.com.hammersoft.poddy.api.pojo.Result;
import br.com.hammersoft.poddy.api.pojo.ResultList;
import javax.swing.JSlider;
import java.awt.Font;
import java.awt.FlowLayout;

public class Test extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -178317461788483784L;
	private JPanel contentPane;
	private JTextField textField;
	private JPanel panel_3;
	private JScrollPane scrollPane;
	
	private static final int menuWidth = 250;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(50);
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					searchAndFill();
				}
			}
		});
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				searchAndFill();
			}
		});
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setSize(new Dimension(menuWidth, 0));
		panel_1.setPreferredSize(new Dimension(menuWidth, 10));
		panel_1.setMinimumSize(new Dimension(menuWidth, 10));
		panel_1.setMaximumSize(new Dimension(menuWidth, 32767));
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setSize(new Dimension(menuWidth, 0));
		scrollPane.setPreferredSize(new Dimension(menuWidth, 10));
		scrollPane.setMinimumSize(new Dimension(menuWidth, 10));
		scrollPane.setMaximumSize(new Dimension(menuWidth, 32767));
		panel_1.add(scrollPane);
		
		panel_3 = new JPanel();
		panel_3.setLayout(new GridLayout(0, 1));
		panel_3.setSize(new Dimension(menuWidth - 5, 0));
		panel_3.setPreferredSize(new Dimension(menuWidth - 1, 10));
		panel_3.setMinimumSize(new Dimension(menuWidth - 5, 10));
		panel_3.setMaximumSize(new Dimension(menuWidth - 5, 32767));
		scrollPane.setViewportView(panel_3);
		
		JLabel lblNewLabel = new JLabel("Resultados");
		panel_1.add(lblNewLabel, BorderLayout.NORTH);
		
		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_1 = new JLabel("Episode 1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setIconTextGap(20);
		lblNewLabel_1.setIcon(new ImageIcon("G:\\Projetos\\Gr\u00E1ficos\\Poddy\\play.png"));
		panel_4.add(lblNewLabel_1, BorderLayout.WEST);
		
		slider = new JSlider();
		panel_4.add(slider, BorderLayout.SOUTH);
		
		panel_5 = new JPanel();
		panel_5.setSize(new Dimension(menuWidth - 5, 0));
		panel_5.setPreferredSize(new Dimension(menuWidth - 1, 10));
		panel_5.setMinimumSize(new Dimension(menuWidth - 5, 10));
		panel_5.setMaximumSize(new Dimension(menuWidth - 5, 32767));
		contentPane.add(panel_5, BorderLayout.EAST);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
	
	private void resizePanelMenu(int height){
		Dimension d = new Dimension(menuWidth - 5, height);
		panel_3.setSize(d);
		panel_3.setPreferredSize(d);
		panel_3.setMinimumSize(d);
		panel_3.setMaximumSize(d);
		
		panel_3.revalidate();
		panel_3.repaint();
		
		scrollPane.revalidate();
		scrollPane.repaint();
		
		revalidate();
		repaint();
	}
	
	private List<JLabel> itens = new ArrayList<>();
	private JPanel panel_2;
	private JPanel panel_4;
	private JLabel lblNewLabel_1;
	private JSlider slider;
	private JPanel panel_5;

	protected void searchAndFill() {
		panel_3.removeAll();
		itens.clear();
		
		try {
			ResultList results = PoddyAPI.searchMedia(textField.getText(), MediaType.podcast);
			for(Result result : results.getResults()){
				System.out.println(result.getArtistName());
				try {
					JLabel label = new JLabel(
							new String(result.getArtistName().getBytes(), "UTF-8"), 
							new ImageIcon(new URL(result.getArtworkUrl60())), 
							SwingConstants.LEADING);
					
					Dimension d = new Dimension(menuWidth - 5, 60);
					label.setSize(d);
					label.setPreferredSize(d);
					label.setMinimumSize(d);
					label.setMaximumSize(d);
					label.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							super.mouseClicked(e);
							panel_2.removeAll();
							try {
								panel_2.add(new PanelPodcastInfo(result, panel_5));
							} catch (PoddyAPIException e1) {
								e1.printStackTrace();
							}
							panel_2.revalidate();
							panel_2.repaint();
						}
					});
					
					panel_3.add(label);
					itens.add(label);
					
					resizePanelMenu(itens.size()*60);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (UnsupportedEncodingException e2) {
					e2.printStackTrace();
				}
			}
		} catch (PoddyAPIException e) {
			e.printStackTrace();
		}
	}

}
