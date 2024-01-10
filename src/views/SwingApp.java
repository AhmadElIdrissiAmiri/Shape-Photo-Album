package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;
import model.IShape;
import model.ISnapShot;
import model.Oval;
import model.Rectangle;
import model.Snapshot;

/**
 * This is my graphical View class SwingApp that extends JFrame.
 */
public class SwingApp extends JFrame {

  private List<ISnapShot> snapShotList;
  private PanelDrawing panelDrawing;
  private int xMax;
  private int yMax;
  private JFrame frame;
  private JPanel jPanelForIDs;
  private JPanel jPanelForButtons;
  private JButton prevButton;
  private JButton selectButton;
  private JButton nextButton;
  private JButton closeButton;
  private JLabel jLabel;
  private int counter = 0;


  /**
   * This is my constructor for the graphical view Swing.
   *
   * @param snapShotList the snap shot list
   * @param xMax         the x max
   * @param yMax         the y max
   */
  public SwingApp(List<ISnapShot> snapShotList, int xMax, int yMax) {
    super();
    this.snapShotList = snapShotList;
    this.nextButton = new JButton(">>Next>>");
    this.prevButton = new JButton("<<Prev>>");
    this.selectButton = new JButton("^^Select^^");
    this.closeButton = new JButton("xx Quit xx");
    this.xMax = xMax;
    this.yMax = yMax;
    setSize(this.xMax, this.yMax);
    this.prevButton.setBackground(Color.cyan);
    this.closeButton.setBackground(Color.cyan);
    this.selectButton.setBackground(Color.pink);
    this.nextButton.setBackground(Color.pink);
    this.frame = new JFrame();
    this.jLabel = new JLabel();


  }


  /**
   * This is a setUp method to build the swing application.
   */
  public void swingInAction() {
    this.frame.setVisible(true);
    this.frame.setTitle("Menu");
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frame.setSize(500, 200);
    for (ISnapShot snapShot : this.snapShotList) {
      panelDrawing = new PanelDrawing(snapShot);
    }

    for (ISnapShot stringID : this.snapShotList) {
      this.jLabel.setText(
          stringID.getSnapShotID().toString() + "  " + stringID.getSnapShotDescription());
      this.frame.add(jLabel);
    }
    jLabel.setVisible(true);
    setVisible(true);
    setTitle("cs5004 Shapes Photo Album Viewer");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jPanelForIDs = new JPanel();
    jPanelForIDs.setBackground(Color.green);
    jPanelForButtons = new JPanel();
    jPanelForButtons.setBackground(Color.yellow);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    GroupLayout jPanel1Layout = new GroupLayout(jPanelForIDs);
    jPanelForIDs.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)

    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
    );

    GroupLayout jPanel2Layout = new GroupLayout(panelDrawing);
    panelDrawing.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 228, Short.MAX_VALUE)
    );

    GroupLayout jPanel3Layout = new GroupLayout(jPanelForButtons);
    jPanelForButtons.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(prevButton, GroupLayout.PREFERRED_SIZE, 90,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(selectButton, GroupLayout.PREFERRED_SIZE, 110,
                    GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(nextButton, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(closeButton))

    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(prevButton)
                    .addComponent(selectButton)
                    .addComponent(nextButton)
                    .addComponent(closeButton))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(Alignment.LEADING)
            .addComponent(jPanelForIDs, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE)
            .addComponent(panelDrawing, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE)
            .addComponent(jPanelForButtons, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelForIDs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(panelDrawing, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                    Short.MAX_VALUE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jPanelForButtons, GroupLayout.PREFERRED_SIZE,
                    GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    );

    pack();
  }


  /**
   * This is a method that Sets up button listeners.
   */
  public void setUpButtonListeners() {
    ActionListener closeButtonListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    };
    this.closeButton.addActionListener(closeButtonListener);

    ActionListener nextButtonListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        counter++;
        if (counter == snapShotList.size()) {
          JOptionPane.showMessageDialog(frame,
              "Sorry!! No more shapes for you.",
              "End",
              JOptionPane.ERROR_MESSAGE);
          counter = snapShotList.size() - 1;

        }
        swingInAction();
      }
    };

    this.nextButton.addActionListener(nextButtonListener);

    ActionListener selectButtonListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    };

    this.selectButton.addActionListener(selectButtonListener);

    ActionListener previousButtonListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        counter--;
        if (counter < 0) {
          JOptionPane.showMessageDialog(frame,
              "Oppss!! This is where you started",
              "Start",
              JOptionPane.ERROR_MESSAGE);
          counter = 0;

        }
        swingInAction();
      }
    };

    this.prevButton.addActionListener(previousButtonListener);

  }


  /**
   * This is my class that extends JPanel to draw the shapes.
   */
  class PanelDrawing extends JPanel {

    private List<IShape> shapesList;
    private ISnapShot snapShot;


    /**
     * This is my constructor that takes in one snapshot at a time.
     *
     * @param snapShot the snapshot
     */
    public PanelDrawing(ISnapShot snapShot) {
      this.snapShot = snapShot;
      this.shapesList = this.snapShot.getShapes();
    }

    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      setBackground(Color.WHITE);
      for (IShape shapes : shapesList) {
        if (shapes.getType().equalsIgnoreCase("oval")) {
          g.drawOval((int) shapes.getCoordinateX(), (int) shapes.getCoordinateY(),
              (int) shapes.getWidthOrRadius(), (int) shapes.getHeightOrRadius());
          g.setColor(new Color(
              (int) shapes.getColor().getR(), (int) shapes.getColor().getG(),
              (int) shapes.getColor().getB()));
          g.fillOval((int) shapes.getCoordinateX(), (int) shapes.getCoordinateY(),
              (int) shapes.getWidthOrRadius(), (int) shapes.getHeightOrRadius());
        } else if (shapes.getType().equalsIgnoreCase("rectangle")) {
          g.drawRect((int) shapes.getCoordinateX(), (int) shapes.getCoordinateY(),
              (int) shapes.getWidthOrRadius(), (int) shapes.getHeightOrRadius());
          g.setColor(new Color(
              (int) shapes.getColor().getR(), (int) shapes.getColor().getG(),
              (int) shapes.getColor().getB()));
          g.fillRect((int) shapes.getCoordinateX(), (int) shapes.getCoordinateY(),
              (int) shapes.getWidthOrRadius(), (int) shapes.getHeightOrRadius());
        }

      }
    }

  }


  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    List<ISnapShot> iSnapShotList = new ArrayList<>();
    IShape shape1 = new Rectangle("R", "rectangle", 20,
        50, 200, 300, new model.Color(255, 200, 201));
    IShape shape2 = new Oval("O", "oval", 70,
        80, 500, 400, new model.Color(100, 150, 200));
    List<IShape> listShape = new ArrayList<>();
    listShape.add(shape1);
    listShape.add(shape2);
    ISnapShot snapShot1 = new Snapshot(LocalDateTime.now(), LocalDateTime.now().toString(),
        "First snapshot", listShape);
    ISnapShot snapShot2 = new Snapshot(LocalDateTime.now(), LocalDateTime.now().toString(),
        "Second snapshot", listShape);
    iSnapShotList.add(snapShot1);
    iSnapShotList.add(snapShot2);
    SwingApp demo = new SwingApp(iSnapShotList, 1000, 1000);
    demo.setUpButtonListeners();
    demo.swingInAction();


  }


}
