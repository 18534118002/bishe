package com.yanxiuhair.framework.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yanxiuhair.framework.filter.ParamsFilter;

import javax.servlet.DispatcherType;
 
/**
 * @ClassName:  ParamsFilterConfig   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author: gaoxiaochuang   
 * @date:   2020年11月3日 上午8:21:51   
 *     
 * @Copyright: 2020 http://www.yanxiuhair.com/ Inc. All rights reserved. 
 * 注意：本内容仅限于许昌妍秀发制品有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Configuration
public class ParamsFilterConfig  {
	
    /**
     * 去除参数头尾空格过滤器
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
    public FilterRegistrationBean paramsFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new ParamsFilter());
        registration.addUrlPatterns("/*");
        registration.setName("paramsFilter");
        registration.setOrder(Integer.MAX_VALUE-1);
        return registration;
    }
}
