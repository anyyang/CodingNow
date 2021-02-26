package cn.ly.functionInterface;/*
 *@program:CodingNow
 *@author: liuyang
 *@since: 2021/2/26  11:39
 *@Description:
 */

import cn.ly.lamada.User;

import java.util.function.Consumer;

@FunctionalInterface
public interface MyFun extends Consumer<User> {
}
