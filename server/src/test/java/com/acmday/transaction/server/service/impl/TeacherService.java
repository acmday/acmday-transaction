package com.acmday.transaction.server.service.impl;

import com.acmday.transaction.server.service.PeopleService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wushaofeng.
 * @date 2020/8/17.
 */
@Slf4j
public class TeacherService implements PeopleService {

    @Override
    public String work() {
        log.info("act=work desc=teacher work!");
        return "teacher";
    }
}
