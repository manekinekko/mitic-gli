package solitaire.solitaire;

import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import solitaire.colonne.ICColonne;
import solitaire.pac.Controleur;
import solitaire.sabot.ICSabot;
import solitaire.tasdecartescolorees.ICTasDeCartesColorees;
import solitaire.usinedecontroleurs.UsineDeControleurs;

public class PSolitaire extends JFrame implements IPSolitaire {

	private static final long serialVersionUID = 1L;
	private static final String APP_TXT_TITLE = "My Solitaire";
	public static final String APP_TXT_ABOUT = APP_TXT_TITLE + " \n"
			+ "Projet GLI - Master 2 - MITIC - ISTIC \n"
			+ "Par Chegham wassim & Gurval Le Bouter";
	private static final String APP_TXT_MENU_FILE = "File";
	private static final String APP_TXT_MENU_FILE_SUBMENU_1 = "Nouvelle Partie";
	private static final String APP_TXT_MENU_FILE_SUBMENU_2 = "Quitter";
	private static final String APP_TXT_MENU_HELP = "Aide";
	private static final String APP_TXT_MENU_HELP_SUBMENU_1 = "A Propos";

	private CSolitaire controleur_;

	public PSolitaire(CSolitaire controleur) {
		super(APP_TXT_TITLE);
		controleur_ = controleur;

		initMenu_();
		initPlateau_();
		finilizeJFrame_();

	}

	private void initMenu_() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu(APP_TXT_MENU_FILE);
		menu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem(APP_TXT_MENU_FILE_SUBMENU_1,
				KeyEvent.VK_N);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
				ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// getContentPane().removeAll();
				// initPlateau_();
				// finilizeJFrame_();
			}
		});
		menu.add(menuItem);
		menuItem = new JMenuItem(APP_TXT_MENU_FILE_SUBMENU_2, KeyEvent.VK_W);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
				ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int ret = JOptionPane.showConfirmDialog(PSolitaire.this,
						"Voulez-vous quitter l'application?");
				if (ret == 0) {

					dispose();
					System.exit(0);
				}

			}
		});
		menu.add(menuItem);

		// --

		menu = new JMenu(APP_TXT_MENU_HELP);
		menu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menu);

		menuItem = new JMenuItem(APP_TXT_MENU_HELP_SUBMENU_1, KeyEvent.VK_A);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,
				ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(PSolitaire.this,
						PSolitaire.APP_TXT_ABOUT);
			}
		});
		menu.add(menuItem);

		setJMenuBar(menuBar);
	}

	private void finilizeJFrame_() {
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(500, 800);
		setLocationRelativeTo(null);
		pack();
		validate();
	}

	private void initPlateau_() {

		ICSabot cSabot = controleur_.getCSabot();
		ICTasDeCartesColorees[] cTasDeCartesColorees = controleur_
				.getCTasDeCartesColorees();
		ICColonne[] cColonnes = controleur_.getCColonnes();

		Box row = Box.createVerticalBox();

		JPanel line1 = new JPanel();
		JPanel line2 = new JPanel();
		JPanel line3 = new JPanel();
		line1.setLayout(new FlowLayout());
		line2.setLayout(new FlowLayout());
		line3.setLayout(new FlowLayout());

		line1.add((JPanel) cSabot.getPresentation());
		cSabot.compacter();

		for (ICTasDeCartesColorees tasDeCartesColorees : cTasDeCartesColorees) {
			line1.add((JPanel) tasDeCartesColorees.getPresentation());
		}

		for (ICColonne colonne : cColonnes) {
			line2.add((JPanel) colonne.getPresentation());
			colonne.decompacter();
			colonne.repositionner();
		}

		row.add(line1);
		row.add(line2);

		JLabel status = new JLabel("Bienvenue dans My Solitaire!");
		line3.add(status);

		row.add(line3);
		add(row);

	}

	public final Controleur getControleur() {
		return controleur_;
	}

}
