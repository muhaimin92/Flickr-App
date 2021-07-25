package net.muhaimin.flickrapp.domain.datamodel

data class TaskResult<out R>(
    val data: R? = null,
    val errorMsg: String? = null,
) {

    companion object {
        fun <R> onSuccess(data: R) = TaskResult<R>(
            data = data
        )

        fun <R> onError(errMsg: String) = TaskResult<R>(
            errorMsg = errMsg
        )
    }

}