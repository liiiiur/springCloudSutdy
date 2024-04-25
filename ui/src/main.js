import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import router from "@/router/index.js";

const app=createApp(App)
app.use(ElementPlus)
app.use(router)

import apiUrls from "@/api/api.js";
import request from "@/utils/request.js";

app.config.globalProperties.$urls=apiUrls
app.config.globalProperties.$request=request

app.mount('#app')
