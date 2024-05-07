const routes=[
    {
        path: '/',
        name: 'index',
        title: '首页',
        component:()=>import('@/pages/index/Index.vue')
    },
    {
        path: '/' +
            '',
        name: 'login',
        title: '登录',
        component:()=>import('@/pages/index/Login.vue')
    },
    {
        path: '/register',
        name: 'register',
        title: '注册',
        component:()=>import('@/pages/index/Register.vue')
    },
    {
        path: '/fromDesign',
        name: 'fromDesign',
        title: '表单设计',
        component:()=>import('@/components/FromDesign.vue')
    },
    {
        path: '/dataV/Index',
        name: 'dataV',
        component:()=>import('@/pages/dataV/Index.vue')
    }
]

export default routes