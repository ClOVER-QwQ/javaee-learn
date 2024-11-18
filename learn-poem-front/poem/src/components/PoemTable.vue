<template>
  <div>
    <table border="1" width="100%" style="text-align: center;">
      <thead>
      <tr>
        <th>编号</th>
        <th>标题</th>
        <th>内容</th>
        <th>操作</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="poem in poems" :key="poem.id">
        <td>{{ poem.id }}</td>
        <td>{{ poem.title }}</td>
        <td>{{ poem.content }}</td>
        <td>
          <button @click="editPoem(poem)">修改</button>
          <button @click="deletePoem(poem.id)">删除</button>
        </td>
      </tr>
      </tbody>
    </table>
    <div>
      <button @click="prevPage" :disabled="currentPage === 1">返回上一页</button>
      <button @click="nextPage" :disabled="currentPage === totalPages">下一页</button>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'PoetryList',
  data() {
    return {
      poems: [],
      currentPage: 1,
      pageSize: 5,
      totalPages: 3 // 初始化 totalPages
    };
  },
  methods: {
    fetchPoems() {
      axios.get(`http://localhost:8080/learnpoem/poem/select?num=${this.currentPage}&size=${this.pageSize}`)
          .then(response => {
            this.poems = response.data;
          })
          .catch(error => {
            console.error('Error fetching poems:', error);
          });
    },
    prevPage() {
      if (this.currentPage > 1) {
        this.currentPage--;
        this.fetchPoems();
      }
    },
    nextPage() {
      if (this.currentPage < this.totalPages) {
        this.currentPage++;
        this.fetchPoems();
      }
    },
    editPoem(poem) {
      // 实现编辑功能的逻辑，例如打开一个模态框或导航到编辑页面
      console.log('Edit poem:', poem);
    },
    deletePoem(poemId) {
      axios.delete(`http://localhost:8080/learnpoem/poem/delete/${poemId}`)
          .then(response => {
            console.log('Poem deleted successfully');
            this.fetchPoems(); // 重新获取诗歌列表以反映删除操作
          })
          .catch(error => {
            console.error('Error deleting poem:', error);
          });
    }
  },
  mounted() {
    this.fetchPoems();
  }
};
</script>

<style scoped>
table {
  width: 100%;
  border-collapse: collapse;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}
</style>
