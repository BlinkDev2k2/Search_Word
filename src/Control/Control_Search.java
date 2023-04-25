package Control;

import View.View_Search;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control_Search implements ActionListener {
    View_Search vs;

    public Control_Search(View_Search vs) {
        this.vs = vs;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String tk = e.getActionCommand();
        switch (tk){
            case "Search":
                this.vs.Search_KeyWords();
        }
    }
}
