package com.zw.admin.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zw.admin.server.page.table.PageTableRequest;
import com.zw.admin.server.page.table.PageTableHandler;
import com.zw.admin.server.page.table.PageTableResponse;
import com.zw.admin.server.page.table.PageTableHandler.CountHandler;
import com.zw.admin.server.page.table.PageTableHandler.ListHandler;
import com.zw.admin.server.dao.SeePersonDao;
import com.zw.admin.server.model.SeePerson;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/seePersons")
public class SeePersonController {

    @Autowired
    private SeePersonDao seePersonDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public SeePerson save(@RequestBody SeePerson seePerson) {
        seePersonDao.save(seePerson);
        return seePerson;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public SeePerson get(@PathVariable Integer id) {
        return seePersonDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public SeePerson update(@RequestBody SeePerson seePerson) {
        seePersonDao.update(seePerson);

        return seePerson;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return seePersonDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<SeePerson> list(PageTableRequest request) {
                return seePersonDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Integer id) {
        seePersonDao.delete(id);
    }
}
