package lessons.less17_ownerLib;

import lessons.less17_ownerLib.config.MobileConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class MobileTest {
    @Test
    public void testMobile(){
        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        System.out.println(config.getDeviceName());
        System.out.println(config.getPlatformName());
        System.out.println(config.getPlatformVersion());

        assertThat(config.getPlatformName()).isEqualTo("IOS");
        assertThat(config.getPlatformVersion()).isEqualTo("13");
        assertThat(config.getDeviceName()).isEqualTo("iPhone 15 Pro Max");

    }

    @Test
    public void testMobileOverride(){
        System.setProperty("platform.version", "14");

        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        System.out.println(config.getPlatformVersion());
        assertThat(config.getPlatformVersion()).isEqualTo("14");
    }

    @Test
    public void testMobileWithAndroid(){
        System.setProperty("device", "google-pixel");

        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        System.out.println(config.getDeviceName());
        System.out.println(config.getPlatformName());
        System.out.println(config.getPlatformVersion());

        assertThat(config.getPlatformName()).isEqualTo("Android");
        assertThat(config.getPlatformVersion()).isEqualTo("12");
        assertThat(config.getDeviceName()).isEqualTo("Google Pixel");
    }
    @Test
    public void testMobileWithIPhone(){
        System.setProperty("device", "iphone-13");

        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        System.out.println(config.getDeviceName());
        System.out.println(config.getPlatformName());
        System.out.println(config.getPlatformVersion());

        assertThat(config.getPlatformName()).isEqualTo("IOS");
        assertThat(config.getPlatformVersion()).isEqualTo("13");
        assertThat(config.getDeviceName()).isEqualTo("iPhone 15 Pro Max");
    }
}
