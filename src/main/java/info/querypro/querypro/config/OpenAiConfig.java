package info.querypro.querypro.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * openAi의 api key를 불러오는 config
 *
 * @author : 임태원
 * @since : 1.0
 **/
@Configuration
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "openai")
public class OpenAiConfig {
    private final KeyConfig keyConfig;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = keyConfig.keyStore(key);
    }
}
