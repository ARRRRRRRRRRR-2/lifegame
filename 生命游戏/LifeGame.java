package 生命游戏;


	import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class LifeGame extends JFrame
{
    private final World world;

    public LifeGame(int rows, int columns)
    {
        world = new World(rows, columns);
        new Thread(world).start();
        add(world);
    }

    public static void main(String[] args)
    {
        LifeGame frame = new LifeGame(40, 50);

        JMenuBar menu = new JMenuBar();
        frame.setJMenuBar(menu);

        JMenu options = new JMenu("Options");
        menu.add(options);

        JMenuItem arrow = options.add("Arrow");
        arrow.addActionListener(frame.new ArrowActionListener());

        JMenuItem square = options.add("Square");
        square.addActionListener(frame.new SquareActionListener());
        
        JMenuItem random = options.add("Random");
        random.addActionListener(frame.new RandomActionListener());

        JMenu help = new JMenu("Help");        
        menu.add(help);
        
        JMenuItem role = help.add("role");
        role.addActionListener(frame.new RoleActionListener());
        
        JMenuItem about = help.add("about");
        about.addActionListener(frame.new AboutActionListener());
        
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1007, 859);
        frame.setTitle("Game of Life");
        frame.setVisible(true);
        frame.setResizable(false);
    }

    class ArrowActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            world.setArrow();
        }
    }

    class SquareActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            world.setSquare();
        }
    }


    class RandomActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            world.setRandom();
        }
    }
    
    class RoleActionListener implements ActionListener{
       public void actionPerformed(ActionEvent e) {
				// 显示消息对话框
				JOptionPane.showMessageDialog(null,
						"click options to choose ", "role",
						JOptionPane.QUESTION_MESSAGE);
			}
       }
    
    class AboutActionListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
		// 显示消息对话框
		JOptionPane.showMessageDialog(null,
				"created by:GTY,DJY", "Designers",
				JOptionPane.WARNING_MESSAGE);
	}}
}