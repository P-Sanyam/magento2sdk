package com.magento2.integration.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Main Configuration class for the Magento2 Integration SDK.
 * Host applications should import this configuration:
 * @Import(MagentoSdkConfig.class)
 */
@Configuration
@ComponentScan(basePackages = "com.magento2.integration")
public class MagentoSdkConfig {
}
