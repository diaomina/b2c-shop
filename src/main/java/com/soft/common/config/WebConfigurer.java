package com.soft.common.config;

import com.soft.common.config.intercepors.AdminLoginInterceptor;
import com.soft.common.config.intercepors.UserLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * @ClassName WebConfigurer
 * @Description 拦截器配置类
 * @Author ljy
 * @Date 2020/2/15 1:25
 * @Version 1.0
 **/
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private UserLoginInterceptor userLoginInterceptor;

    @Autowired
    private AdminLoginInterceptor adminLoginInterceptor;

    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {

    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        // 注册用户拦截器
        interceptorRegistry.addInterceptor(userLoginInterceptor)
                .addPathPatterns("/alipayAction/goAlipay")
                .addPathPatterns("/alipayAction/return")
                .addPathPatterns("/cartAction/goCartMain")
                .addPathPatterns("/cartAction/doCartAdd")
                .addPathPatterns("/cartAction/doCartUpdate")
                .addPathPatterns("/cartAction/doCartDelete")
                .addPathPatterns("/orderAction/goOrderAdd")
                .addPathPatterns("/orderAction/doOrderAdd")
                .addPathPatterns("/orderAction/goOrderState")
                .addPathPatterns("/orderAction/doPay")
                .addPathPatterns("/userAction/doLogout")
                .addPathPatterns("/userAction/goUserCenter")
                .addPathPatterns("/userAction/goChangePassword")
                .addPathPatterns("/userAction/goUserAmount")
                .addPathPatterns("/userAction/doUserAmount")
                .addPathPatterns("/userReceiveAction/goUserReceiveMain")
                .addPathPatterns("/userReceiveAction/goUserReceiveAdd")
                .addPathPatterns("/userReceiveAction/doUserReceiveAdd")
                .addPathPatterns("/userReceiveAction/goUserReceiveEdit")
                .addPathPatterns("/userReceiveAction/doUserReceiveEdit")
                .addPathPatterns("/userReceiveAction/doUserReceiveDelete")
                .addPathPatterns("/userReceiveAction/doDefault");

        // 注册管理员拦截器
        interceptorRegistry.addInterceptor(adminLoginInterceptor)
                .addPathPatterns("/adAction/goAdMain")
                .addPathPatterns("/adAction/goAdAdd")
                .addPathPatterns("/adAction/doAdAdd")
                .addPathPatterns("/adAction/goAdEdit")
                .addPathPatterns("/adAction/doAdEdit")
                .addPathPatterns("/adAction/doAdDelete")
                .addPathPatterns("/adAction/doAdState")
                .addPathPatterns("/adAction/doStopBatchAd")
                .addPathPatterns("/adminAction/doLogout")
                .addPathPatterns("/adminAction/goIndex")
                .addPathPatterns("/goodsAction/goGoodsMain")
                .addPathPatterns("/goodsAction/goGoodsAdd")
                .addPathPatterns("/goodsAction/doGoodsAdd")
                .addPathPatterns("/goodsAction/goGoodsEdit")
                .addPathPatterns("/goodsAction/doGoodsEdit")
                .addPathPatterns("/goodsAction/goGoodsMain")
                .addPathPatterns("/goodsAction/doGoodsDelete")
                .addPathPatterns("/goodsAction/doGoodsIsMarketable")
                .addPathPatterns("/goodsAction/doStopBatchGoods")
                .addPathPatterns("/goodsCategoryAction/goGoodsCategoryMain")
                .addPathPatterns("/goodsCategoryAction/goGoodsCategoryAdd")
                .addPathPatterns("/goodsCategoryAction/doGoodsCategoryAdd")
                .addPathPatterns("/goodsCategoryAction/doGoodsCategoryState")
                .addPathPatterns("/goodsCategoryAction/goGoodsCategoryEdit")
                .addPathPatterns("/goodsCategoryAction/doGoodsCategoryEdit")
                .addPathPatterns("/goodsCategoryAction/doGoodsCategoryDelete")
                .addPathPatterns("/orderAction/goOrderMain")
                .addPathPatterns("/orderAction/goOrderEdit")
                .addPathPatterns("/orderAction/doOrderEdit")
                .addPathPatterns("/orderAction/doDelBatchOrder")
                .addPathPatterns("/userAction/goUserMain")
                .addPathPatterns("/userAction/goUserAdd")
                .addPathPatterns("/userAction/doUserAdd")
                .addPathPatterns("/userAction/goUserEdit")
                .addPathPatterns("/userAction/doUserEdit")
                .addPathPatterns("/userAction/doUserState")
                .addPathPatterns("/userAction/stopBatchUser")
                .addPathPatterns("/userAction/goUserChangePassword");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {

    }

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {

    }

    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {

    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
}
