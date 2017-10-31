import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MovieGUI extends JFrame {
    private JTextField movieTitleTextField;
    private JSlider ratingSlider;
    private JCheckBox wouldSeeAgainCheckBox;
    private JLabel sliderValueLabel;
    private JPanel mainPanel;

    MovieGUI() {
        setTitle("MovieGUI");
        setContentPane(mainPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ratingSlider.setMinimum(0);
        ratingSlider.setMaximum(5);

        ratingSlider.setValue(0);
        sliderValueLabel.setText("0 stars");

        ratingSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int value = ratingSlider.getValue();
                sliderValueLabel.setText (value + " stars");
                updateOpinion();
            }
        });
    }
    public void updateOpinion() {
        boolean seeAgain = wouldSeeAgainCheckBox.isSelected();
        String movieName = movieTitleTextField.getText();
        int rating = ratingSlider.getValue();
        String template = "You rated %s %d stars and you %s see again.";
        String opinion = String.format(template, movieName, rating, seeAgain);
    }
}
