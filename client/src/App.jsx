import { useEffect, useState } from 'react'
import './App.css'
import { createTask, deleteTask, getTask, updateTask } from './api/task'

function App() {
  const [tasks, setTasks] = useState([])
  const [taskName, setTaskName] = useState()
  const [taskDesc, setTaskDesc] = useState()
  const [taskCompleted, setTaskCompleted] = useState(false)
  const [taskType, setTaskType] = useState('create')
  const [taskId, setTaskId] = useState(null)

  useEffect(() => {
    fetchTask()
  }, [])

  const fetchTask = async () => {
    const response = await getTask();
    // console.log(response.data);
    setTasks(response.data)
  }

  const create = () => {
    setTaskType('create')
    setTaskId(null)
  }
  const update = (id, name, desc , isCompleted) => {
    setTaskType('update')
    setTaskId(id)
    setTaskName(name)
    setTaskDesc(desc)
    setTaskCompleted(isCompleted)
  }

  const createT = async () => {
    try {
      const response = await createTask(taskName, taskDesc)
      console.log(response)
      if (response.status === 200) {
        fetchTask()
        setTaskName('')
        setTaskDesc('')
      }
    } catch (error) {
      console.log(error)
    }
  }
  const updateT = async () => {
    try {
      const response = await updateTask(taskId, taskName, taskDesc , taskCompleted)
      // console.log(response)
      if (response.status === 200) {
        fetchTask()
        setTaskName('')
        setTaskDesc('')
        create()
      }
    } catch (error) {
      console.log(error)
    }
  }
  const deleteT = async (id) => {
    try {
      const response = await deleteTask(id)
      // console.log("delete with Id", id)
      console.log(response)
      fetchTask()
    } catch (error) {
      console.log(error)
    }
  }
  return (
    <>
      <div className='page'>

        {taskType === 'create' && <div className='editTaskContainer'>
          <div className='inputBox'>
            <p>TaskName :</p>
            <input
              type="text"
              placeholder='Task Name'
              value={taskName}
              onChange={(e) => { setTaskName(e.target.value) }} />

          </div>
          <div className='inputBox'>
            <p>Task Description :</p>
            <textarea
              value={taskDesc}
              placeholder='Task Description'
              onChange={(e) => { setTaskDesc(e.target.value) }}
            />
          </div>
          <button onClick={createT}>Create Task</button>
        </div>}

        {taskType === 'update' && <div className='editTaskContainer'>
          <div className='inputBox'>
            <span>Completed :</span>
            <input
              type="checkbox"
              value={taskName}
              checked={taskCompleted}
              onChange={(e) => {setTaskCompleted(e.target.checked)}}
              />

          </div>
          <div className='inputBox'>
            <p>TaskName :</p>
            <input
              type="text"
              placeholder='Task Name'
              value={taskName}
              disabled />

          </div>
          <div className='inputBox'>
            <p>Task Description :</p>
            <textarea
              value={taskDesc}
              placeholder='Task Description'
              onChange={(e) => { setTaskDesc(e.target.value) }}
            />
          </div>
          <button onClick={updateT}>Update</button>
        </div>}


        <div className='tasksContainer'>
          <button onClick={create}>Create Task</button>
          {tasks.map((task, index) => {
            return <div key={index} className='showTasks'>
              <input type="checkbox" value={task.isCompleted} checked={task.isCompleted} readOnly />
              <h3>{task.task}</h3>
              <p>{task.taskDescription}</p>
              <button onClick={() => { update(task.id, task.task, task.taskDescription , task.isCompleted) }} >Update</button>
              <span onClick={() => { deleteT(task.id) }}>X</span>
            </div>
          })}
        </div>

      </div>
    </>
  )
}

export default App
