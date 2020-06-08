package kz.eserzhanov.dynamic_field.dynamic_field.database.repository;

import com.querydsl.core.types.dsl.EntityPathBase;
import kz.eserzhanov.dynamic_field.dynamic_field.database.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface ExCustomRepository <T extends BaseModel, P extends EntityPathBase<T>, ID extends Serializable>
        extends JpaRepository<T, ID>, QuerydslPredicateExecutor<T>, QuerydslBinderCustomizer<P> {

    @Override
    default void customize(QuerydslBindings bindings, P root) {
    }
}
