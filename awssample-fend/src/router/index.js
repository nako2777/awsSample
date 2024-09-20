import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path:'/',
      component: () => import('../views/HomePage.vue')
    },
    {
      path:'/S3',
      component: () => import('../views/S3Page.vue')
    },
    {
      path:'/RDS',
      component: () => import('../views/RDSPage.vue')
    },
    {
      path:'/Cognito',
      component: () => import('../views/CognitoPage.vue')
    },
    {
      path:'/CognitoByFargte',
      component: () => import('../views/FargateToCognito.vue')
    }
    // {
    //   path: '/about',
    //   name: 'about',
    //   // route level code-splitting
    //   // this generates a separate chunk (About.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import('../views/AboutView.vue')
    // }
  ]
})

export default router
