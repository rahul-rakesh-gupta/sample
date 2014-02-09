package sample

import grails.transaction.Transactional

@Transactional
class UserService {
    static Map<String, List> userCache = [:]


    Map getUser() {
        return userCache
    }

    Boolean addUser(User newUser) {
        List<User> userList = []
        if (newUser.username == null) {
            return false
        }
        if (userCache.containsKey('Users')) {
            userList = userCache.get('Users')
            for(User user : userList) {
                if (user.username.equalsIgnoreCase(newUser.username)) {
                    return false
                }
            }
            userList.add(newUser)
            userCache.put('Users', userList)
            return true
        } else {
            userList.add(newUser)
            userCache.put('Users', userList)
            return true
        }
    }
}