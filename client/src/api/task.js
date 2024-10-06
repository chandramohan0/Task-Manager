import axios from "axios";

const BACKEND_ORIGIN_URL = "http://ec2-13-201-20-236.ap-south-1.compute.amazonaws.com:8080/api/task";

const createTask = async (task, taskDescription) => {
  try {
    const response = await axios.post(`${BACKEND_ORIGIN_URL}/add`, {
      task,
      taskDescription,
    });
    return response;
  } catch (error) {
    return error.response;
  }
};

const updateTask = async (taskId, task, taskDescription , isCompleted) => {
  try {
    const response = await axios.put(
      `${BACKEND_ORIGIN_URL}/update/id/${taskId}`,
      {
        task,
        taskDescription,
        isCompleted
      }
    );
    return response;
  } catch (error) {
    return error.response;
  }
};

const getTask = async () => {
  try {
    const response = await axios.get(`${BACKEND_ORIGIN_URL}/all`);
    return response;
  } catch (error) {
    return error.response;
  }
};

const getTaskById = async (id) => {
  try {
    const response = await axios.get(`${BACKEND_ORIGIN_URL}/id/${id}`);
    return response;
  } catch (error) {
    return error.response;
  }
};

const deleteTask = async (id) => {
  try {
    const response = await axios.delete(
      `${BACKEND_ORIGIN_URL}/delete/id/${id}`
    );
    return response;
  } catch (error) {
    return error.response;
  }
};

export { createTask, updateTask, getTask, getTaskById, deleteTask };
