<template>
  <div>
  <!--面包屑导航区域-->
  <el-breadcrumb separator-class="el-icon-arrow-right">
    <el-breadcrumb-item :to="{ path: '/main' }">首页</el-breadcrumb-item>
    <el-breadcrumb-item>权限管理</el-breadcrumb-item>
    <el-breadcrumb-item>角色列表</el-breadcrumb-item>
  </el-breadcrumb>
  <!--卡片视图-->
  <el-card>
    <!--按钮-->
    <el-row>
      <el-col>
        <el-button type="primary">添加角色</el-button>
      </el-col>
    </el-row>
    <!--角色列表-->
    <el-table :data="roleList" stripe>
      <!-- 展开列 -->
      <el-table-column type="expand">
        <template slot-scope="scope">
          <el-row :class="['bdbottom', i===0? 'bdtop':'','vcenter']"  v-for="(item,i) in scope.row.rights" :key="item.id">
            <!-- 一级权限 -->
            <el-col :span="5">
              <el-tag closable >{{ item.authName }}</el-tag>
              <i class="el-icon-caret-right"></i>
            </el-col>
            <!-- 二级三级权限 -->
            <el-col :span="19">
              <!-- 渲染二级权限 -->
              <el-row v-for="(item2,i2) in item.children" :key="item2.id" :class="[i2 === 0 ? '':'bdtop','vcenter']">
                <el-col  :span="6">
                  <el-tag closable type="success">{{ item2.authName }}</el-tag>
                  <i class="el-icon-caret-right"></i>
                </el-col>
                <el-col :span="18">
                  <el-tag closable type="warning" v-for="(item3) in item2.children" :key="item3.id">{{ item3.authName }}</el-tag>
                </el-col>
              </el-row>
            </el-col>
          </el-row>
        </template>
      </el-table-column>
      <!-- 索引列 -->
      <el-table-column type="index" label="#"></el-table-column>
      <el-table-column label="角色名称" prop="name"></el-table-column>
      <el-table-column label="角色描述" prop="desc"></el-table-column>
      <el-table-column label="操作" >
        <template slot-scope="scope">
          <!--编辑按钮-->
          <el-button v-bind:disabled="scope.row.id == 1? true:false" type="primary" icon="el-icon-edit" :modal="scope" size="small" circle @click="edit(scope.row)"></el-button>
          <!--删除按钮-->
          <el-button v-bind:disabled="scope.row.id == 1? true:false" type="danger" icon="el-icon-delete" size="small" @click="del(scope.row)" circle></el-button>
          <!--分配角色按钮-->
          <el-tooltip class="item" effect="dark" :content="'为'+ scope.row.name + '分配权限'"  :enterable="false" placement="top">
            <el-button v-bind:disabled="scope.row.id == 1? true:false" type="warning" icon="el-icon-setting" size="small" circle></el-button>
          </el-tooltip>
        </template>
      </el-table-column>
    </el-table>
  </el-card>
  </div>
</template>

<script>
export default {
  created () {
    this.getRoleList()
  },
  data() {
    return {
      roleList: []
    }
  },
  methods: {
    async getRoleList() {
      const { data: res } = await this.$axios.get('/role/list')
      this.roleList = res.data
      console.log(this.roleList)
    }
  }
}
</script>

<style lang="less" scoped>
.el-tag{
  margin: 7px;
}
.bdtop{
  border-top: 1px solid #eee;
}
.bdbottom{
  border-bottom: 1px solid #eee;
}
.vcenter{
  display: flex;
  align-items: center;
}
</style>
