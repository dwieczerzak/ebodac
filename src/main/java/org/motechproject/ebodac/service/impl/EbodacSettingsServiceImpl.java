package org.motechproject.ebodac.service.impl;

import org.motechproject.ebodac.service.EbodacSettingsService;

import org.motechproject.server.config.SettingsFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the {@link org.motechproject.ebodac.service.EbodacSettingsService} uses {@link SettingsFacade}.
 */
@Service("ebodacSettingsService")
public class EbodacSettingsServiceImpl implements EbodacSettingsService {

    private Logger logger = LoggerFactory.getLogger(EbodacSettingsServiceImpl.class.toString());

    @Autowired
    private SettingsFacade settingsFacade;

    @Override
    public String getSettingsValue(String key) {
        if (null == key) {
            return null;
        }
        return settingsFacade.getProperty(key);
    }

    @Override
    public void logInfoWithModuleSettings(String info) {
        String bundleName = getSettingsValue("org.motechproject.ebodac.bundle.name");
        String sampleSetting = getSettingsValue("org.motechproject.ebodac.sample.setting");
        logger.info("{} (module name: {}, with sample setting: {})", new String[] { info, bundleName, sampleSetting });
    }
}