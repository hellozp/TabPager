package com.yhy.tabnav.tpg;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yhy.tabnav.config.PagerConfig;
import com.yhy.tabnav.handler.ResultHandler;

/**
 * author : 颜洪毅
 * e-mail : yhyzgn@gmail.com
 * time   : 2017-09-14 21:11
 * version: 1.0.0
 * desc   : 每个子页面必须实现的接口，请参照参照TpgFragment
 */
public interface PagerFace<RT> {
    /**
     * 获取实现该接口的Fragment
     * <p>
     * 适配器中只使用Fragment，所以必须在这里获取到
     *
     * @return 实现该接口的Fragment
     */
    Fragment getFragment();

    /**
     * 设置跟布局
     *
     * @param root 跟布局
     */
    void setRoot(RT root);

    /**
     * 设置页面配置参数
     *
     * @param config 页面配置参数
     */
    void setPagerConfig(PagerConfig config);

    /**
     * 获取到当前Fragment所依附的Activity
     *
     * @param context 上下文对象
     */
    void getPagerActivity(Context context);

    /**
     * 子类Fragment创建View时调用
     *
     * @param inflater           布局映射器
     * @param container          容器
     * @param savedInstanceState 保存的参数
     * @return 页面整个View
     */
    View onCreatePagerView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * 页面显示隐藏状态改变时调用
     *
     * @param isVisible 是否显示
     */
    void onPagerVisible(boolean isVisible);

    /**
     * 获取[记载中]显示的View
     *
     * @param inflater           布局映射器
     * @param container          容器
     * @param savedInstanceState 保存的参数
     * @return [记载中]显示的View
     */
    View getLoadingView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * 获取[空数据]显示的View
     *
     * @param inflater           布局映射器
     * @param container          容器
     * @param savedInstanceState 保存的参数
     * @return [空数据]显示的View
     */
    View getEmptyView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * 获取[错误]显示的View
     *
     * @param inflater           布局映射器
     * @param container          容器
     * @param savedInstanceState 保存的参数
     * @return [错误]显示的View
     */
    View getErrorView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * 获取[成功]显示的View
     *
     * @param inflater           布局映射器
     * @param container          容器
     * @param savedInstanceState 保存的参数
     * @return [成功]显示的View
     */
    View getSuccessView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * 初始化数据
     */
    void initData();

    /**
     * 初始化事件
     */
    void initListener();

    /**
     * 自动判断是否加载数据
     */
    void shouldLoadData();

    /**
     * 重新加载数据
     *
     * @param args 携带的参数
     */
    void reloadData(Bundle args);

    /**
     * 将页面状态改为[加载中]
     */
    void onLoading();

    /**
     * 将页面状态改为[成功]
     */
    void onSuccess();

    /**
     * 将页面状态改为[空数据]
     */
    void onEmpty();

    /**
     * 将页面状态改为[错误]
     */
    void onError();
}