package net.muhaimin.flickrapp.domain

interface DomainMapper  <T, DomainModel>{

    fun toDomainModel(model: T): DomainModel
}