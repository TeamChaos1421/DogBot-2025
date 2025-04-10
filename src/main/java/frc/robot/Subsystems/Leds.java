package frc.robot.Subsystems;


import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.AddressableLEDBufferView;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Leds extends SubsystemBase {
    private final AddressableLED m_led;
    private final AddressableLEDBuffer m_ledBuffer;
    private final AddressableLEDBufferView m_leftView;
    private final AddressableLEDBufferView m_rightView;

    public Leds () {
        m_led = new AddressableLED(9);

        m_ledBuffer = new AddressableLEDBuffer(512);
        m_led.setLength(m_ledBuffer.getLength());
        m_leftView = m_ledBuffer.createView(0, 255);
        m_rightView = m_ledBuffer.createView(256, 511);

        m_led.start();
    }

    public void setFrame(int[][] frame){
        for (var pixel = 0; pixel < 256; pixel++) {
            m_ledBuffer.setRGB(pixel, frame[pixel][0], frame[pixel][1], frame[pixel][2]);
            m_rightView.setRGB(pixel, frame[pixel][0], frame[pixel][1], frame[pixel][2]);
            m_leftView.setRGB(pixel, frame[pixel][0], frame[pixel][1], frame[pixel][2]);
        }

        m_led.setData(m_ledBuffer);
    };
}
