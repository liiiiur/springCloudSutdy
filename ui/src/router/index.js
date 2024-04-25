import {createRouter,createWebHistory} from 'vue-router'
import routes from "./routes.js";

const pages=Object.keys(routes).map((path)=>{
    const name = path.match(/\.\/(.*)\.vue$/)[1]
    return {
        path: `/${name.toLowerCase()}`,
        component: routes[path],
        name,
    }
})

const router=createRouter({
    history: createWebHistory(),
    routes: [
        ...routes,
        ...pages
    ],
})

router.beforeEach((to, from, next) => {
    // 继续前进 next()
    // 返回 false 以取消导航
})

// 全局后置钩子，这里可以加入改变页面标题等操作
router.afterEach((to, from) => {
    const _title = to.meta.title
    if (_title) {
        window.document.title = _title
    }
})


export default router