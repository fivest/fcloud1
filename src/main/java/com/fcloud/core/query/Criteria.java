package com.fcloud.core.query;

import com.fcloud.core.model.Model;
import com.fcloud.core.page.Pagination;
import com.fcloud.core.page.PaginationFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询条件主体类
 */
public class Criteria {

    private Model model;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    private List<Criterion> criterions;

    public List<Criterion> getCriterions() {
        if (criterions == null) {
            criterions = new ArrayList<Criterion>();
        }
        return criterions;
    }

    public void setCriterions(List<Criterion> criterions) {
        this.criterions = criterions;
    }

    private Pagination page;

    public<T> Pagination<T> getPage() {
        if (page == null) {
            page = PaginationFactory.newDefPage(1);
        }
        return page;
    }

    public<T> void setPage(Pagination<T> page) {
        this.page = page;
    }

    public Criteria add(Criterion criterion) {
        getCriterions().add(criterion);
        return this;
    }

}
