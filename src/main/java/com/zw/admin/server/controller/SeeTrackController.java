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
import com.zw.admin.server.dao.SeeTrackDao;
import com.zw.admin.server.model.SeeTrack;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/seeTracks")
public class SeeTrackController {

    @Autowired
    private SeeTrackDao seeTrackDao;

    @PostMapping
    @ApiOperation(value = "保存")
    public SeeTrack save(@RequestBody SeeTrack seeTrack) {
        seeTrackDao.save(seeTrack);

        return seeTrack;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public SeeTrack get(@PathVariable Long id) {
        return seeTrackDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public SeeTrack update(@RequestBody SeeTrack seeTrack) {
        seeTrackDao.update(seeTrack);

        return seeTrack;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return seeTrackDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<SeeTrack> list(PageTableRequest request) {
                return seeTrackDao.list(request.getParams(), request.getOffset(), request.getLimit());
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        seeTrackDao.delete(id);
    }
}
