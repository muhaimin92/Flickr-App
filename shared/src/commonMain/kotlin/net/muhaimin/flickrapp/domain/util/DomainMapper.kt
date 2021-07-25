package net.muhaimin.flickrapp.domain.util

interface DomainMapper  <T, DomainModel>{

    fun toDomainModel(model: T): DomainModel
}