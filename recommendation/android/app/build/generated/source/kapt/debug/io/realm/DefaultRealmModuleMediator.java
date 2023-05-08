package io.realm;


import android.util.JsonReader;
import io.realm.ImportFlag;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(3);
        modelClasses.add(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class);
        modelClasses.add(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class);
        modelClasses.add(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(3);
        infoMap.put(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class, io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class, io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteMovieRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class, io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class)) {
            return io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class)) {
            return io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteMovieRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class)) {
            return io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class)) {
            return "MovieCollectionCompleteSpeaker";
        }
        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class)) {
            return "MovieCollectionCompleteMovie";
        }
        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class)) {
            return "MovieCollectionComplete";
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public Class<? extends RealmModel> getClazzImpl(String className) {
        checkClassName(className);

        if (className.equals("MovieCollectionCompleteSpeaker")) {
            return it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class;
        }
        if (className.equals("MovieCollectionCompleteMovie")) {
            return it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class;
        }
        if (className.equals("MovieCollectionComplete")) {
            return it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class;
        }
        throw getMissingProxyClassException(className);
    }

    @Override
    public boolean hasPrimaryKeyImpl(Class<? extends RealmModel> clazz) {
        return it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class.isAssignableFrom(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class)) {
                return clazz.cast(new io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy());
            }
            if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class)) {
                return clazz.cast(new io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteMovieRealmProxy());
            }
            if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class)) {
                return clazz.cast(new io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class)) {
            it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy.MovieCollectionCompleteSpeakerColumnInfo columnInfo = (it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy.MovieCollectionCompleteSpeakerColumnInfo) realm.getSchema().getColumnInfo(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class);
            return clazz.cast(io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy.copyOrUpdate(realm, columnInfo, (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker) obj, update, cache, flags));
        }
        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class)) {
            it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteMovieRealmProxy.MovieCollectionCompleteMovieColumnInfo columnInfo = (it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteMovieRealmProxy.MovieCollectionCompleteMovieColumnInfo) realm.getSchema().getColumnInfo(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class);
            return clazz.cast(io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteMovieRealmProxy.copyOrUpdate(realm, columnInfo, (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie) obj, update, cache, flags));
        }
        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class)) {
            it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy.MovieCollectionCompleteColumnInfo columnInfo = (it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy.MovieCollectionCompleteColumnInfo) realm.getSchema().getColumnInfo(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class);
            return clazz.cast(io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy.copyOrUpdate(realm, columnInfo, (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete) obj, update, cache, flags));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public long insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class)) {
            throw new IllegalArgumentException("Embedded objects cannot be copied into Realm by themselves. They need to be attached to a parent object");
        } else if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class)) {
            throw new IllegalArgumentException("Embedded objects cannot be copied into Realm by themselves. They need to be attached to a parent object");
        } else if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class)) {
            return io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy.insert(realm, (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class)) {
                throw new IllegalArgumentException("Embedded objects cannot be copied into Realm by themselves. They need to be attached to a parent object");
            } else if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class)) {
                throw new IllegalArgumentException("Embedded objects cannot be copied into Realm by themselves. They need to be attached to a parent object");
            } else if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class)) {
                io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy.insert(realm, (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class)) {
                    throw new IllegalArgumentException("Embedded objects cannot be copied into Realm by themselves. They need to be attached to a parent object");
                } else if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class)) {
                    throw new IllegalArgumentException("Embedded objects cannot be copied into Realm by themselves. They need to be attached to a parent object");
                } else if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class)) {
                    io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public long insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class)) {
            throw new IllegalArgumentException("Embedded objects cannot be copied into Realm by themselves. They need to be attached to a parent object");
        } else if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class)) {
            throw new IllegalArgumentException("Embedded objects cannot be copied into Realm by themselves. They need to be attached to a parent object");
        } else if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class)) {
            return io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy.insertOrUpdate(realm, (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class)) {
                throw new IllegalArgumentException("Embedded objects cannot be copied into Realm by themselves. They need to be attached to a parent object");
            } else if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class)) {
                throw new IllegalArgumentException("Embedded objects cannot be copied into Realm by themselves. They need to be attached to a parent object");
            } else if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class)) {
                io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy.insertOrUpdate(realm, (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class)) {
                    throw new IllegalArgumentException("Embedded objects cannot be copied into Realm by themselves. They need to be attached to a parent object");
                } else if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class)) {
                    throw new IllegalArgumentException("Embedded objects cannot be copied into Realm by themselves. They need to be attached to a parent object");
                } else if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class)) {
                    io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class)) {
            throw new IllegalArgumentException("Importing embedded classes from JSON without a parent is not allowed");
        }
        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class)) {
            throw new IllegalArgumentException("Importing embedded classes from JSON without a parent is not allowed");
        }
        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class)) {
            return clazz.cast(io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class)) {
            throw new IllegalArgumentException("Importing embedded classes from JSON without a parent is not allowed");
        }
        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class)) {
            throw new IllegalArgumentException("Importing embedded classes from JSON without a parent is not allowed");
        }
        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class)) {
            return clazz.cast(io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class)) {
            return clazz.cast(io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy.createDetachedCopy((it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class)) {
            return clazz.cast(io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteMovieRealmProxy.createDetachedCopy((it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class)) {
            return clazz.cast(io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteRealmProxy.createDetachedCopy((it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> boolean isEmbedded(Class<E> clazz) {
        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class)) {
            return true;
        }
        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class)) {
            return true;
        }
        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class)) {
            return false;
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> void updateEmbeddedObject(Realm realm, E unmanagedObject, E managedObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) managedObject.getClass().getSuperclass();

        if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker.class)) {
            io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteSpeakerRealmProxy.updateEmbeddedObject(realm, (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker) unmanagedObject, (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteSpeaker) managedObject, cache, flags);
        } else if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie.class)) {
            io.realm.it_unibo_sistemidigitali_exam_jhon_ai_model_MovieCollectionCompleteMovieRealmProxy.updateEmbeddedObject(realm, (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie) unmanagedObject, (it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionCompleteMovie) managedObject, cache, flags);
        } else if (clazz.equals(it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete.class)) {
            throw getNotEmbeddedClassException("it.unibo.sistemidigitali.exam.jhon_ai.model.MovieCollectionComplete");
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

}
