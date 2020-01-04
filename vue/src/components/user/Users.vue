<template>
  <div>
  <!--面包屑导航区域-->
  <el-breadcrumb separator-class="el-icon-arrow-right">
    <el-breadcrumb-item :to="{ path: '/main' }">首页</el-breadcrumb-item>
    <el-breadcrumb-item>用户管理</el-breadcrumb-item>
    <el-breadcrumb-item>用户列表</el-breadcrumb-item>
  </el-breadcrumb>
  <!--卡面视图区域-->
  <el-card >
    <el-row :gutter="20">
      <el-col :span="7">
        <!--搜素框-->
        <el-input placeholder="请输入搜索内容" class="input-with-select">
          <el-button slot="append" icon="el-icon-search"></el-button>
        </el-input>
      </el-col>
      <el-col :span="4"><el-button type="primary" @click=" addUSerVisible = true">添加用户</el-button></el-col>
    </el-row>
  <!--添加用户面板-->
  <el-dialog title="添加新用户" :visible.sync="addUSerVisible" width="600px">
    <el-form :model="userForm" ref="userFromRef" label-width="0">
      <el-form-item label="用户名" label-width="60px">
        <el-input v-model="userForm.username"></el-input>
      </el-form-item>
      <el-form-item label="姓名" label-width="60px">
        <el-input v-model="userForm.name"></el-input>
      </el-form-item>
      <el-form-item label="密码" label-width="60px">
        <el-input v-model="userForm.username"></el-input>
      </el-form-item>
      <el-form-item label="电话" label-width="60px">
        <el-input v-model="userForm.username"></el-input>
      </el-form-item>
      <el-form-item label="邮箱" label-width="60px">
        <el-input v-model="userForm.username"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="addUSerVisible = false">取 消</el-button>
      <el-button type="primary" @click="addUSerVisible = false , add(userFormRef)">确 定</el-button>
    </div>
  </el-dialog>
    <!--表格区域-->
    <el-table style="width: 100%" :data="userList" border>
      <el-table-column  label="#"  width="60" prop="id">
      </el-table-column>
      <el-table-column label="姓名" prop="name">
      </el-table-column>
      <el-table-column label="邮箱" prop="email">
      </el-table-column>
      <el-table-column label="电话" prop="tel">
      </el-table-column>
      <el-table-column label="角色"  prop="role.name">
      </el-table-column>
      <el-table-column label="状态"  prop="mg_state">
        <template slot-scope="scope">
        <el-switch v-model="scope.row.mg_state" @change="userChangeStatused(scope.row)">
        </el-switch>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <!--编辑按钮-->
            <el-button type="primary" icon="el-icon-edit" :modal="scope" size="small" circle></el-button>
          <!--删除按钮-->
            <el-button type="danger" icon="el-icon-delete" size="small" circle></el-button>
          <!--分配角色按钮-->
          <el-tooltip class="item" effect="dark" :content="'为'+ scope.row.name + '分配角色'"  :enterable="false" placement="top">
            <el-button type="warning" icon="el-icon-setting" size="small" circle></el-button>
          </el-tooltip>
        </template>
      </el-table-column>
    </el-table>
    <!--分页-->
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="queryInfo.pagenum"
      :page-sizes="[6, 8, 10, 50]"
      :page-size="userInfo.size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="userInfo.totalElements">
    </el-pagination>
  </el-card>
  </div>
</template>

<script>
export default {
  created() {
    this.getUserList()
  },
  data() {
    return {
      // 获取用户列表的参数
      queryInfo: {
        query: '',
        pagenum: 1,
        pagesize: 6
      },
      userForm: {
        username: '',
        name: '',
        password: ''
      },
      userList: [],
      userInfo: '',
      // 是否显示添加用户面板
      addUSerVisible: false
    }
  },
  // name: 'Users',
  methods: {
    async getUserList() {
      const { data: res } = await this.$axios.get('/users', { params: this.queryInfo })
      this.userInfo = res.data
      this.userList = res.data.content
    },
    add(userFormRef) {
      console.log(this.$refs[userFormRef])
    },
    handleSizeChange(newSize) {
      // pagesize改变触发
      this.queryInfo.pagesize = newSize
      this.getUserList()
    },
    handleCurrentChange(newPage) {
      // 页码改变触发
      this.queryInfo.pagenum = newPage
      this.getUserList()
    },
    async userChangeStatused(user) {
      // 用户状态改变
      this.$message.closeAll()
      if (user.id === 1) {
        return this.$message.error('该用户不可操作')
      }
      const res01 = await this.$axios.post('/u/update', user).catch(error => {
        return this.$message.error('操作失败')
      })
      if (res01.status === 200) return this.$message.success('操作成功')
    }
  }
}
</script>

<style lang="less" scoped>

</style>
