<template>
  <el-container class="main-container">
    <!--头部区域-->
    <el-header>
      <div>
        <img class="logo" src="../assets/logo.png" alt="logo">
        <span>电商后台管理系统</span>
      </div>
      <el-button type="info" @click="logout">退出</el-button>
    </el-header>
    <el-container>
      <!--侧边栏区域-->
      <el-aside :width="isCollapse ? '64px' : '200px'">
        <div class="toggle-button" @click="toggleCollapse">|||</div>
        <el-menu background-color="#333744" text-color="#fff"
         active-text-color="#409EEF" :collapse="isCollapse"
         unique-opened :collapse-transition="false" :router="true"
         :default-active="$route.path">
         <!--一级菜单-->
          <el-submenu :index="item.id+''"  v-for="item in menusList" :key="item.id">
            <!--一级菜单模板-->
            <template slot="title">
              <i :class="iconsObj[item.id]"></i>
              <span>{{ item.name }}</span>
            </template>
            <!--二级菜单-->
            <el-menu-item :index="'/'+child.path" v-for="child in item.children" :key="child.id">
              <template slot="title">
                <i class="el-icon-menu"></i>
                <span>{{ child.name }}</span>
              </template>
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <!--主体区域-->
      <el-main><router-view></router-view></el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  data () {
    return {
      // 左侧菜单栏数据
      menusList: [],
      iconsObj: {
        '1': 'iconfont icon-yonghu',
        '3': 'iconfont icon-quanxian',
        '6': 'iconfont icon-shangpinchuangjian',
        '10': 'iconfont icon-5',
        '12': 'iconfont icon-icon-test'
      },
      // 是否折叠侧栏菜单
      isCollapse: false
    }
  },
  created () {
    /* 初始化左侧菜单 */
    this.getMenuList()
  },
  name: 'Main',
  methods: {
    /* 退出功能 */
    logout () {
      window.sessionStorage.removeItem('token')
      this.$router.push('/login')
    },
    /* 获取所有菜单项 */
    async getMenuList () {
      const res = await this.$axios.get('menus')
      // eslint-disable-next-line no-return-assign
      if (res.data.meta.status === 200) return this.menusList = res.data.data
      this.$message.error('左侧菜单栏请求数据失败')
    },
    toggleCollapse () {
      this.isCollapse = !this.isCollapse
    }
  }
}
</script>
<style lang="less" scoped>
.main-container{
  height: 100%;
}
.el-header{
  background-color: #373d41;
  display: flex;
  justify-content: space-between;
  align-items: center;
  color: #fff;
  font-size: 20px;
  > div{
    display: flex;
    align-items: center;
    span{
      margin-left: 15px;
      cursor: pointer;
    }
  }
;
}
.el-aside{
  background-color: #333744;
  .el-menu{
    border-right: none;
  }
}
.main{
  background-color: #EAEDF1;
}
.logo{
  border-radius: 50%;
}
  .iconfont{
    margin-right: 10px;
  }
.toggle-button{
  background-color: #4A5064;
  font-size: 10px;
  line-height: 24px;
  text-align: center;
  color: #fff;
  cursor: pointer;
  letter-spacing: 0.2em;
}
</style>
