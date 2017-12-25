package com.hypertrack.main;

import com.hypertrack.entity.EncodedData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author abhinav
 * @date 24/12/17
 */
@SpringBootApplication
@EnableJpaRepositories("com.hypertrack.repository")
@ComponentScan(basePackages= {"com.hypertrack.rest","com.hypertrack.service"})
@EntityScan(basePackageClasses = EncodedData.class)
public class PolylineMain {
    public static void main(String[] args) {
        SpringApplication.run(PolylineMain.class, args);
    }
}
