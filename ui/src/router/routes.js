const routes=[
    {
        path: '/',
        name: 'index',
        title: '首页',
        component:()=>import('@/pages/index/Login.vue')
    },
    {
        path: '/login',
        name: 'login',
        title: '登录',
        component:()=>import('@/pages/index/Login.vue')
    },
    {
        path: '/register',
        name: 'register',
        title: '注册',
        component:()=>import('@/pages/index/Register.vue')
    }
]

export default routes