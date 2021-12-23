package cn.hzu.sotacy.config;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author Jasper Zhan
 * @date 2021年12月20日 19:01
 */
public class MybatisPlusConfig {

    public static void main(String[] args) {

        FastAutoGenerator.create("jdbc:mysql://localhost:3306/sotacy?serverTimezone=UTC",
                        "root", "123456")

                .globalConfig(builder -> {
                    builder.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(System.getProperty("user.dir")+"\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("cn.hzu") // 设置父包名
                            .moduleName("sotacy") // 设置父包模块名
                            .entity("model")
                            .service("service")
                            .serviceImpl("service/impl")
                            .controller("controller")
                            .mapper("dao")
                            .xml("mapper")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir")+"\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> builder.addInclude("admin", "blank_question", "certificate", "choice_question",
                                "course", "course_unit", "judgment_question", "learning_status", "user",
                                "user_certificate", "user_learning_course", "video") // 设置需要生成的表名
                        .addTablePrefix("dms_") // 设置过滤表前缀
                        .serviceBuilder()
                        .formatServiceFileName("%sService")
                        .formatServiceImplFileName("%sServiceImpl")
                        .entityBuilder()
                        .enableLombok()
                        .enableTableFieldAnnotation()
                        .controllerBuilder()
                        .formatFileName("%sController")
                        .enableRestStyle()
                        .mapperBuilder()
                        .superClass(BaseMapper.class)
                        .formatMapperFileName("%sDao")
                        .enableMapperAnnotation()
                        .formatXmlFileName("%sMapper"))
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
