package vn.tvd.BookStore_BE.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import vn.tvd.BookStore_BE.entity.Category;

@Configuration
public class MethodRestConfig implements RepositoryRestConfigurer {
    @Autowired
    private EntityManager entityManager;
    private String url = "http://localhost:8080";

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        //expose Id
        config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream().map(Type::getJavaType).toArray(Class[]::new));

        HttpMethod[] disableMethods = {
                HttpMethod.POST,
                HttpMethod.PUT,
                HttpMethod.PATCH,
                HttpMethod.DELETE,
        };

//        Chặn các phương thức của class entity cụ thể
//        blockHttpMethods(Category.class, config, disableMethods);
//        blockHttpMethods(User.class, config, new HttpMethod[]{HttpMethod.DELETE});
    }

    private void blockHttpMethods(Class c, RepositoryRestConfiguration config, HttpMethod[] methods) {
        config.getExposureConfiguration()
                .forDomainType(c)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(methods))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(methods));
    }
}
