package com.ll.demo.handler.test.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BFileResolve implements IFileStrategy {

    @Override
    public FileTypeResolveEnum gainFileType() {
        return FileTypeResolveEnum.File_B_RESOLVE;
    }


    @Override
    public void resolve(Object objectparam) {
        log.info("B 类型解析文件，参数：{}", objectparam);
        //B类型解析具体逻辑
    }
}