<template>
 <div>
   <!--面包屑导航区域-->
   <el-breadcrumb separator-class="el-icon-arrow-right">
     <el-breadcrumb-item :to="{ path: '/main' }">首页</el-breadcrumb-item>
     <el-breadcrumb-item>权限管理</el-breadcrumb-item>
     <el-breadcrumb-item>权限列表</el-breadcrumb-item>
   </el-breadcrumb>
   <!--卡片视图-->
   <el-card>
    <el-table :data="rightsList" border stripe>
      <el-table-column label="#" type="index"></el-table-column>
      <el-table-column label="权限名称" prop="authName"></el-table-column>
      <el-table-column label="路径" prop="path"></el-table-column>
      <el-table-column label="权限名称" prop="level">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.level == 0">一级</el-tag>
          <el-tag type="success" v-if="scope.row.level == 1">二级</el-tag>
          <el-tag type="warning" v-if="scope.row.level == 2">三级</el-tag>
        </template>
      </el-table-column>
    </el-table>
   </el-card>
 </div>
</template>

<script>
export default {
  created() {
    this.getRightsList()
  },
  data() {
    return {
      // 权限列表
      rightsList: []
    }
  },
  methods: {
    async getRightsList () {
      const { data: res } = await this.$axios.get('/rights/list')
      if (res.meta.status !== 200) {
        return this.$message.error('获取权限列表失败!')
      }
      this.rightsList = res.data
    }
  }
}
</script>

<style scoped>

</style>
