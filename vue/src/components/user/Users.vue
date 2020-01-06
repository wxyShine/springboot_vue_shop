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
        <el-input placeholder="请输入姓名进行搜索" class="input-with-select" v-model="tableDataName">
          <el-button slot="append" icon="el-icon-search" @click="doFilter"></el-button>
        </el-input>
      </el-col>
      <el-col :span="4"><el-button type="primary" @click="addUSerVisible = true">添加用户</el-button></el-col>
    </el-row>
    <!--表格区域-->
    <el-table style="width: 100%" :data="userList.slice((currentPage-1)*pageSize,currentPage*pageSize)" border>
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
        <el-switch v-model="scope.row.mg_state" @change="userChangeStatused(scope.row)"  v-bind:disabled="scope.row.id == 1? true:false">
        </el-switch>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <!--编辑按钮-->
            <el-button v-bind:disabled="scope.row.id == 1? true:false" type="primary" icon="el-icon-edit" :modal="scope" size="small" circle @click="edit(scope.row)"></el-button>
          <!--删除按钮-->
            <el-button v-bind:disabled="scope.row.id == 1? true:false" type="danger" icon="el-icon-delete" size="small" @click="del(scope.row)" circle></el-button>
          <!--分配角色按钮-->
          <el-tooltip class="item" effect="dark" :content="'为'+ scope.row.name + '分配角色'"  :enterable="false" placement="top">
            <el-button v-bind:disabled="scope.row.id == 1? true:false" type="warning" icon="el-icon-setting" size="small" circle></el-button>
          </el-tooltip>
        </template>
      </el-table-column>
    </el-table>
    <!--分页-->
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[2, 5, 10, 50]"
      :page-size="pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="parseInt(total)">
    </el-pagination>
  </el-card>
    <!--添加用户面板-->
    <el-dialog title="添加新用户"  width="50%" :visible.sync="addUSerVisible">
      <el-form label-width="70px" :model="userForm"  :rules="rules" ref="userFormRef">
        <el-form-item label="用户名"  prop="username">
          <el-input v-model="userForm.username"></el-input>
        </el-form-item>
        <el-form-item label="密码"  prop="password">
          <el-input v-model="userForm.password"></el-input>
        </el-form-item>
        <el-form-item label="姓名"  prop="name">
          <el-input v-model="userForm.name"></el-input>
        </el-form-item>
        <el-form-item label="电话"  prop="tel">
          <el-input v-model="userForm.tel"></el-input>
        </el-form-item>
        <el-form-item label="邮箱"  prop="email">
          <el-input v-model="userForm.email"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="addUSerVisible = false,resetForm('userFormRef')">取 消</el-button>
        <el-button type="primary" @click="okAdd('userFormRef')">确 定</el-button>
      </div>
    </el-dialog>
    <!--修改用户面板-->
    <el-dialog title="添加新用户"  width="50%" :visible.sync="editUSerVisible">
      <el-form label-width="70px" :model="userForm"  :rules="rules" ref="userFormRef">
        <el-form-item label="用户名"  prop="username">
          <el-input v-model="userForm.username"></el-input>
        </el-form-item>
        <el-form-item label="密码"  prop="password">
          <el-input v-model="userForm.password"></el-input>
        </el-form-item>
        <el-form-item label="姓名"  prop="name">
          <el-input v-model="userForm.name"></el-input>
        </el-form-item>
        <el-form-item label="电话"  prop="tel">
          <el-input v-model="userForm.tel"></el-input>
        </el-form-item>
        <el-form-item label="邮箱"  prop="email">
          <el-input v-model="userForm.email"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="editUSerVisible = false,resetForm('userFormRef')">取 消</el-button>
        <el-button type="primary" @click="okEdit('userFormRef')">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  created() {
    this.getUserList()
  },
  data() {
    return {
      userForm: {
        username: '',
        name: '',
        password: '',
        tel: '',
        email: ''
      },
      rules: {
        name: [
          { required: true, message: '请输入姓名', trigger: 'blur' },
          { min: 2, max: 5, message: '长度在 2 到 5 个字符', trigger: 'blur' }
        ],
        username: [
          { required: true, message: '请输用户名', trigger: 'blur' },
          { min: 2, max: 5, message: '长度在 2 到 5 个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输密码', trigger: 'blur' },
          { min: 3, max: 12, message: '长度在 3 到 12 个字符', trigger: 'blur' }
        ],
        tel: [
          { required: true, message: '请输手机号', trigger: 'blur' }
        ],
        email: [
          { required: true, message: '请输邮箱', trigger: 'blur' },
          { type: 'email', message: '请输入正确的邮箱地址', trigger: 'blur' }
        ]
      },
      userList: [],
      users: [],
      // 是否显示添加用户面板
      addUSerVisible: false,
      // 是否显示修改用户面板
      editUSerVisible: false,
      currentPage: 1,
      pageSize: 2,
      total: 0,
      tableDataName: ''
    }
  },
  methods: {
    async getUserList() {
      const { data: res } = await this.$axios.get('/users')
      this.userList = res.data
      this.users = res.data
      this.total = this.userList.length
    },
    handleSizeChange(newSize) {
      // pagesize改变触发
      this.pageSize = newSize
    },
    handleCurrentChange(newPage) {
      // 页码改变触发
      this.currentPage = newPage
    },
    async userChangeStatused(user) {
      // 用户状态改变
      this.$message.closeAll()
      const res01 = await this.$axios.post('/u/update', user).catch(error => {
        return this.$message.error('操作失败')
      })
      if (res01.status === 200) return this.$message.success('操作成功')
    },
    doFilter() {
      this.$message.closeAll()
      // 搜索
      if (this.tableDataName === '') {
        this.userList = this.users
        // 页面数据改变重新统计数据数量和当前页
        this.currentPage = 1
        this.total = this.userList.length
        this.$message.warning('查询条件不能为空！')
        return false
      }
      //  清空表格数据
      this.userList = []
      this.users.forEach((value, index) => {
        if (value.name) {
          if (value.name.indexOf(this.tableDataName) >= 0) {
            this.userList.push(value)
          }
        }
      })
      // 页面数据改变重新统计数据数量和当前页
      this.currentPage = 1
      this.total = this.userList.length
    },
    async okAdd(userFormRef) {
      this.$refs[userFormRef].validate(async valid => {
        if (valid) {
          const res = await this.$axios.post('/u/save', this.userForm)
          if (res.data.meta.status === 200) {
            // 添加成功
            this.addUSerVisible = false
            this.$message.success('添加成功!')
            this.getUserList()
            this.resetForm(userFormRef)
          } else {
            this.$message.error('添加失败!')
          }
        } else {
          return false
        }
      })
    },
    resetForm(userFormRef) {
      this.$refs[userFormRef].resetFields()
    },
    edit(user) {
      this.$message.closeAll()
      this.userForm = user
      this.editUSerVisible = true
    },
    okEdit(userFormRef) {
      this.$refs[userFormRef].validate(async valid => {
        if (valid) {
          const res = await this.$axios.post('/u/update', this.userForm)
          if (res.data.meta.status === 200) {
            // 修改成功
            this.editUSerVisible = false
            this.$message.success('修改成功!')
            this.getUserList()
          } else {
            this.$message.error('修改失败!')
          }
        } else {
          return false
        }
      })
    },
    del(user) {
      this.$confirm('此操作将永久删除,' + user.name + ' 是否继续?', '提示', {
        cancelButtonText: '取消',
        confirmButtonText: '确定',
        type: 'warning'
      }).then(async() => {
        const res = await this.$axios.post('/u/delete', user)
        if (res.data.meta.status === 200) {
          this.$message({
            type: 'success',
            message: '删除成功!'
          })
          this.getUserList()
        } else {
          this.$message({
            type: 'error',
            message: '删除失败!'
          })
        }
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    }
  }
}
</script>

<style lang="less" scoped>
</style>
