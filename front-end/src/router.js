// import { component } from "vue/types/umd"
import HomePage from "./pages/HomePage.vue"
import AddPage from "./pages/AddPage.vue"
import UpdatePage from "./pages/UpdatePage.vue"

export default [

    {
        path: "/",
        component: HomePage
    },
    {
        path: "/add",
        component: AddPage
    },
    {
        path: "/update/:id",
        component: UpdatePage
    }

]
