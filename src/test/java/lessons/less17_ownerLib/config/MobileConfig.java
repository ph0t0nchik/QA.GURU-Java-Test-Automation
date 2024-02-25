package lessons.less17_ownerLib.config;

import org.aeonbits.owner.Config;

//@Config.LoadPolicy(Config.LoadType.FIRST) //будет всегд зачитывать только "classpath:${device}.properties"
//@Config.LoadPolicy(Config.LoadType.MERGE) //будет всегд зачитывать только "classpath:mobile.properties"

//Но лучше расставлять все по приоритетам самому и не использовать @Config.LoadPolicy

@Config.Sources({
        //чтобы работать с разными .properties файлами
        "classpath:${device}.properties",
        //
        "classpath:mobile.properties"

})
// после добавления работы с разными .properties мы можем поменять целый тестинг, например в этих файлах могут
// быть описаны данные для разных дев-стендов, у каждого будут свои пароли, логины, другие данные и тд

public interface MobileConfig extends Config {

    @Key("device.name")
    String getDeviceName();
    @Key("platform.name")
    String getPlatformName();
    @Key("platform.version")
    String getPlatformVersion();
}
