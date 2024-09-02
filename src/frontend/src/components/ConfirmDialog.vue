<template>
  <div v-if="show" class="dialog-overlay">
    <div class="dialog-box">
      <p>Are you sure you want to delete this order?</p>
      <button @click="confirm">Yes</button>
      <button @click="cancel">No</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      show: false,
      resolve: null
    };
  },
  methods: {
    showDialog() {
      this.show = true;
      return new Promise((resolve) => {
        this.resolve = resolve;
      });
    },
    confirm() {
      this.show = false;
      this.resolve(true);
    },
    cancel() {
      this.show = false;
      this.resolve(false);
    }
  }
}
</script>

<style scoped>
.dialog-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
}

.dialog-box {
  background: white;
  padding: 20px;
  border-radius: 8px;
  text-align: center;
}

.dialog-box button {
  margin: 0 10px;
}
</style>
