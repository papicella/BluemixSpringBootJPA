package pas.cloud.webapp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

public class DataSourceConfiguration
{
    private static Log logger = LogFactory.getLog(DataSourceConfiguration.class);
    @Configuration()
    @Profile({ "cloud" })
    public static class CloudConfiguration extends AbstractCloudConfig {
        @Bean(destroyMethod = "close")
        public javax.sql.DataSource dataSource() {
            logger.info(" CloudConfiguration : using connectionFactory to set data source");
            return connectionFactory().dataSource();
        }
    }
}
