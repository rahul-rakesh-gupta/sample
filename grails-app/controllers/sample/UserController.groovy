package sample

import grails.converters.JSON

class UserController{

    UserService userService

    def show = {
        Map userMap = userService.getUser()
        render (view:'show', model:[data: userMap as JSON])
    }

    def add () {

        String username = params['username']
        User newUser = new User()
        newUser.username = username
        newUser.save()

        Boolean successful = userService.addUser(newUser)
        Map messageMap = [:]
        messageMap.put('User', newUser)
        if (successful) {
            messageMap.put("Status", "User Added Successfully")
            render (view:'show', model:[data: messageMap as JSON])
        }
        else {
            messageMap.put('User', newUser)
            messageMap.put("Status", "User Not Added")
            render (view:'show', model:[data: messageMap as JSON])
        }

    }

}