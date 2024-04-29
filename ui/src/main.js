import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import router from '@/router/index.js';
import VForm3 from 'vform3-builds'
import DataV  from '@dataview/datav-vue3'

import 'element-plus/dist/index.css'  //引入element-plus样式
import 'vform3-builds/dist/designer.style.css'  //引入VForm3样式

const app=createApp(App)
app.use(ElementPlus)
app.use(router)
app.use(VForm3)
app.use(DataV);

import apiUrls from '@/api/api.js';
import request from '@/utils/request.js';

app.config.globalProperties.$apiUrl=apiUrls
app.config.globalProperties.$http=request

app.mount('#app')
