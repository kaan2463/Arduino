import gnu.io.CommPortIdentifier;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Enumeration;

public class Shower extends Canvas {

    private byte [] imageBytes;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        try {
            if(this.imageBytes!=null){
                g.drawImage(byteArrayToImage(this.imageBytes),40,40,null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void flushScreen(byte [] data){
        imageBytes=data;
        this.repaint();
    }

    private byte [] imageToByteArray() throws IOException {
        BufferedImage bImage = ImageIO.read(new File("C:\\Users\\KHAN\\IdeaProjects\\arduino_cam\\src\\bb55.bmp"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "bmp", bos );
        byte [] data = bos.toByteArray();
        return data;
    }

    private Image byteArrayToImage(byte [] data) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        BufferedImage image = ImageIO.read(bis);
//        ImageIO.write(bImage2, "jpg", new File("output.jpg") );
        return image;
    }

    public Shower() {
        JFrame jFrame=new JFrame();
        jFrame.add(this);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(400,400);
        jFrame.setVisible(true);
    }
}
