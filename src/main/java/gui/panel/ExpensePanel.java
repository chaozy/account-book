package gui.panel;

/**
 * ExpensePanel displays the analytical data according to the expense of this month
 */

import service.ExpenseService;
import gui.util.CircleProgressBar;
import gui.util.ColourUtil;
import gui.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class ExpensePanel extends WorkingPanel {

    private JLabel lMonthSpend = new JLabel("Month Spend");
    private JLabel lTodaySpend = new JLabel("Daily Spend");
    private JLabel lAvgSpend = new JLabel("Average Spend");
    private JLabel lMonthLeft = new JLabel("Montly Budget");
    private JLabel lDayLeft = new JLabel("Daily Budget");
    private JLabel lTimeLeft = new JLabel("Days Left");
    private JLabel lTotalSpend = new JLabel("Total Spend");

    private JLabel vMonthSpend = new JLabel();
    private JLabel vTodaySpend = new JLabel();
    private JLabel vAvgSpendPerDay = new JLabel();
    private JLabel vMonthAvailable = new JLabel();
    private JLabel vDayAvgAvailable = new JLabel();
    private JLabel vTimeLeft = new JLabel();
    private JLabel vTotalSpend = new JLabel();

    private static ExpensePanel panel = new ExpensePanel();

    public static ExpensePanel getInstance(){ return panel; }

    private static ExpensePanel instance = new ExpensePanel();

    CircleProgressBar bar;

    public ExpensePanel() {
        this.setLayout(new BorderLayout());
        bar = new CircleProgressBar();

        GUIUtil.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16), lMonthSpend, lTodaySpend,
                lAvgSpend, lMonthLeft, lDayLeft, lTimeLeft, vAvgSpendPerDay, vMonthAvailable,
                vDayAvgAvailable, vTimeLeft, lTotalSpend);
        GUIUtil.setFont(new Font("Impact", Font.BOLD, 23), vMonthSpend, vTodaySpend, vTotalSpend);

        this.add(center(), BorderLayout.CENTER);
        this.add(south(), BorderLayout.SOUTH);
    }

    private JPanel north(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.add(lTotalSpend);
        panel.add(vTotalSpend);
        System.out.println(vTotalSpend.getText());
        return panel;
    }
    private JPanel center() {
        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 0;
        p.add(north(), c);

        c.gridx = 0;
        c.gridy = 1;
        p.add(west(), c);


        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 1;
        p.add(bar, c);
        return p;
    }

    private Component west() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 1));
        p.add(lMonthSpend);
        p.add(vMonthSpend);
        p.add(lTodaySpend);
        p.add(vTodaySpend);
        return p;
    }

    private JPanel south() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 4));

        p.add(lAvgSpend);
        p.add(lMonthLeft);
        p.add(lDayLeft);
        p.add(lTimeLeft);
        p.add(vAvgSpendPerDay);
        p.add(vMonthAvailable);
        p.add(vDayAvgAvailable);
        p.add(vTimeLeft);

        return p;
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(ExpensePanel.instance);
    }

    @Override
    public void addListener() {}

    @Override
    public void updatePanel() {
        ExpenseService service = new ExpenseService();
        vMonthSpend.setText(Integer.toString(service.getMonthSpend()));
        vTodaySpend.setText(Integer.toString(service.getTodaySpend()));
        vAvgSpendPerDay.setText(Double.toString(service.getAvgSpendPerDay()));
        vTimeLeft.setText(Integer.toString(service.getTimeLeft()));
        vDayAvgAvailable.setText(Double.toString(service.getDayAvgAvailable()));
        vMonthAvailable.setText(Integer.toString(service.getMonthAvailable()));
        vTotalSpend.setText(Integer.toString(service.getTotalSpend()));
        int progress = service.getUsagepecentage();

        if (service.overBudget()){ bar.setBackgroundColor(ColourUtil.warningColor); }
        else{ bar.setBackgroundColor(ColourUtil.blueColor); }
        bar.setProgress(progress);
        bar.setForegroundColor(ColourUtil.getByPercentage(progress));
        updateUI();
    }

}
