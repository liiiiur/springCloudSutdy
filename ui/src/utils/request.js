import axios from "axios";

// 创建 Axios 实例
const service = axios.create({
    baseURL: '/api', // 后端 API 地址
    timeout: 10000, // 请求超时时间
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded'//默认以formdata形式发送数据
    }
});

// 请求拦截器
service.interceptors.request.use(
    config => {
        // 在发送请求之前可以做一些处理，比如添加 token
        return config;
    },
    error => {
        // 发送请求错误时的处理
        console.error('Request error:', error);
        return Promise.reject(error);
    }
);

// 响应拦截器
service.interceptors.response.use(
    response => {
        // 对响应数据进行处理，比如解析返回的数据
        return response.data;
    },
    error => {
        // 响应错误时的处理
        console.error('Response error:', error);
        return Promise.reject(error);
    }
);

// 定义各种访问后端的方法
const request = {
    // 发送 GET 请求
    get(url, params) {
        return service.get(url, {params});
    },

    // 发送 POST 请求
    post(url, data) {
        return service.post(url, data);
    },

    // 发送 PUT 请求
    put(url, data) {
        return service.put(url, data);
    },

    // 发送 DELETE 请求
    delete(url) {
        return service.delete(url);
    },
};

export default request;
