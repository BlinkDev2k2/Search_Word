package View;

import Control.Control_Search;
import Model.Model_Search;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View_Search extends JFrame {
    private Model_Search ms;
    private JTextArea vbt, tkt;
    private JLabel vb, tk, kq;

    public View_Search() {
        this.ms = new Model_Search();
        this.Layout();
    }

    public void Layout(){
        this.setSize(500, 500);
        this.setTitle("Search Words");
        this.setLocationRelativeTo(null);
        Font f = new Font("Arial", Font.BOLD, 18);

        JPanel box, button;
        box  = new JPanel();
        button = new JPanel();

        vb = new JLabel("Văn Bản");
        vb.setFont(f);
        tk = new JLabel("Từ Khóa");
        tk.setFont(f);
        kq = new JLabel("Kết Quả :");
        kq.setFont(f);

        vbt = new JTextArea();
        vbt.setFont(f);
        tkt = new JTextArea();
        tkt.setFont(f);

        ActionListener ac = new Control_Search(this);
        JButton search = new JButton("Search");
        search.addActionListener(ac);

        box.setLayout(new GridLayout(4,1,5,5));
        button.setLayout(new GridLayout(1,2,5,5));
        box.setPreferredSize(new Dimension(450, 400));
        button.setPreferredSize(new Dimension(450, 100));

        JScrollPane js = new JScrollPane(vbt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        box.add(vb);
        box.add(js);
        box.add(tk);
        box.add(tkt);

        button.add(search);
        button.add(kq);

        this.setLayout(new BorderLayout());
        this.add(box, BorderLayout.CENTER);
        this.add(button, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }

    public void Search_KeyWords(){
        this.ms.setS(this.vbt.getText());
        String key = this.tkt.getText();
        String s = this.ms.getS();
        int len = s.length();
        short dem = 0;
        for(int i = 0; i < len;){
            int j = s.indexOf(key, i);
            if(j < 0) break;
            else {
                ++dem;
                i = j + 1;
            }
        }
        this.kq.setText("Ket qua la: " + String.valueOf(dem) + " tu " + key);
    }
}
